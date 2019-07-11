<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>
</head>

<body>
  <!-- footer -->
  <div class="footer">
    <div class="container">
      <div class="news_letter">
        <span>NEWS LETTER</span>
        <div class="form-group">
          <input type="text">
          <button>SEND</button>
        </div>
      </div>
      <p>Subscribe to know about the latest sale style updates & more!</p>
      <div class="share">
        <a href="#"><i class="icon s1"></i></a>
        <a href="#"><i class="icon s2"></i></a>
        <a href="#"><i class="icon s3"></i></a>
        <a href="#"><i class="icon s4"></i></a>
        <a href="#"><i class="icon s5"></i></a>
      </div>
      <div class="nav">

      </div>
    </div>
  </div>
  <script src="${APP_PATH }/static/m/js/sidenav.js"></script>
  <script>
    /*
      POST请求，无参数
      MlbackFootNav/getMlfrontFootNavAllq 
      {
          "name": "Buyer Service 3",
          "icon": "",
          "link": "#"
      }
    */

    var footerData = [{
        "name": "Megalook_Hair",
        "icon": "plus",
        "link": "javascript:;",
        "children": []
      },
      {
        "name": "Buyer_Service",
        "icon": "plus",
        "link": "javascript:;",
        "children": []
      },
      {
        "name": "Activity",
        "icon": "plus",
        "link": "javascript:;",
        "children": []
      },
      {
        "name": "Client_Service_Support",
        "icon": "plus",
        "link": "javascript:;",
        "children": []
      }
    ];

    var map = {
      Megalook_Hair: "mlbackFootNavOneList",
      Buyer_Service: "mlbackFootNavTwoList",
      Activity: "mlbackFootNavThreeList",
      Client_Service_Support: "mlbackFootNavFourList",
    }

    var param = window.location.href.indexOf('?') > -1 ? window.location.href.split('?')[1].split('&').reduce(function (
      obj, item) {
      var arr = item.split('=');
      obj[arr[0]] = arr[1];
      return obj;
    }, {}) : null;

    $.ajax({
      url: '${APP_PATH}/MlbackFootNav/getMlfrontFootNavAll',
      type: 'post',
      async: false,
      success: function (data) {
        // console.log(data);
        var resData = data.extend;
        if (resData.isNav === 0) {
          alert('没获取到相关数据')
        }

        if (param && resData[param.block]) {
          var html = '';
          if (resData.isNav === 0) {
            html = '没获取到相关数据';
          }
          if (resData.isNav === 1) {
            var article = getArticle(resData[param.block], param.id);
            html = '<div class="article-title">' + article.footnavName + '</div>' +
              '<div class="article-content">' + article.footnavDesc + '</div>';
          }
          $('.main').html(html);
        }

        if (resData.isNav === 1) {
          for (var key in footerData) {
            var block = map[footerData[key].name];
            var fData = resData[block];
            for (var key2 in fData) {
              //加一个判断		footnavIfIncome		每条数据都有这个字段
              //0，不能点		比如有的就纯粹是，联系方式
              //1,能点进去		有富文本内容的。
              if (fData[key2].footnavIfIncome) {
                footerData[key].children.push({
                  "name": fData[key2].footnavName,
                  "icon": "",
                  "link": "/ShopTemplate/MlbackFootNav/toMlfrontFootNavPage?block=" + block + "&id=" + fData[
                    key2].footnavId
                })
              } else {
                footerData[key].children.push({
                  "name": fData[key2].footnavName,
                  "icon": "",
                  "link": "javascritp:;"
                })
              }
            }
          }
        }
      }
    });
    $('.nav').Side(footerData);

    function getArticle(data, id) {
      var article = {};
      for (var i = 0, len = data.length; i < len; i += 1) {
        if (parseInt(data[i].footnavId) === parseInt(id)) {
          article = data[i];
          break;
        }
      }
      return article;
      // console.log(article)
    }
  </script>
</body>

</html>