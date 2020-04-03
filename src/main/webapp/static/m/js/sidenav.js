/**
 * sideNav auto render
 * by lzb
 * @me：lvzhenbbang@outlook.com
 * github: https://github.com/lvzhenbang
 */
// sideNav
(function($) {
  $.fn.Side = function(data) {
    var createBox = function(cls) {
      var ul = $('<ul/>');
      return cls ? ul.addClass(cls) : ul;
    }

    var createItem = function(data) {
      return '<li>' +
          '<a href="' + data.link + '">' +
            '<span class="text">' + (data.name.replace(/\_/g, ' ')) + '</span>' +
            '<i class="icon ' + data.icon + '"></i>' +
          '</a>' +
        '</li>';
    }

    this.render = function() {
      var box = createBox();

      for (var d in data) {
        var item = $(createItem(data[d]));
        if (data[d].children && data[d].children.length > 0) {
          var childBox = createBox('children');
          for (var dd in data[d].children) {
            childBox.append(createItem(data[d].children[dd]));
          }
          
          if (data[d].name === 'Client_Service_Support') {
        	  item.find('.icon').removeClass('plus').addClass('sub');
        	  childBox.addClass('show').css('display', 'block');
          }
          item.append(childBox);
        }
        box.append(item);
      }

      this.append(box);
    }

    this.trigger = function() {
      this.on('click', function(e) {
        var target = e.target;
        var activeEl = $(target);
        var activeElParent = activeEl.parent();
        function tabState(item, ul) {
          if (ul.length) {
            if (ul.hasClass('show')) {
            	item.find('.icon').removeClass('sub').addClass('plus')
              ul.removeClass('show').hide();
            } else {
            	item.find('.icon').removeClass('plus').addClass('sub')
              ul.addClass('show').show();
            } 
          }
        }
      
        if (activeEl[0].nodeName === 'A') {
          var nextUl = activeEl.next('ul');
          tabState($(activeEl[0]), nextUl)
        }
      
        if (activeElParent[0].nodeName === 'A') {
          var activeElParentUl = activeElParent.next('ul');
          tabState($(activeElParent[0]), activeElParentUl)
        }
      })
    }

    this.init = function() {
      this.render();
      this.trigger();
    }

    return this.init()
  }
})($);