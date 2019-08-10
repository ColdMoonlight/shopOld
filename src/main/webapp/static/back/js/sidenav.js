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
    	if(data.url === '#' || !data.url) {
    		data.url = 'javascript:;';
    	}
      return '<li>' +
          '<div class="item">' +
            '<a href="' + data.url  + '">' +
              '<i class="glyphicon ' + data.icon + '"></i>' +
              '<span class="text">' + data.name + '</span>' +
            '</a>' +
          '</div>' +
        '</li>';
    }

    this.render = function() {
      var box = createBox();

      for (var d in data) {
        var item = $(createItem(data[d]));
        item.find('.item').addClass('closed')
        if (data[d].children && data[d].children.length > 0) {
          var childBox = createBox('children');
          for (var dd in data[d].children) {
            childBox.append(createItem(data[d].children[dd]));
          }
          item.append(childBox);
        }
        box.append(item);
      }

      this.append(box);
    }

    this.trigger = function() {
      var activeObj = this.find('.active');
      var items = this.find('.item');
      items.each(function(index, item) {
        var itemEl = $(item);
        var itemChildrenEl = $(item).parent().find('.children');
        itemEl.on('click', function() {
          if (itemEl !== activeObj) {
            activeObj && activeObj.removeClass('active');
            itemEl.addClass('active');
            activeObj = itemEl;
          }
          if (itemChildrenEl.length > 0) {
            if (!itemEl.hasClass('closed')) {
              itemEl
                .addClass('closed')
                .find('.glyphicon')
                .removeClass('glyphicon-chevron-down')
                .addClass('glyphicon-chevron-right')
              itemChildrenEl.hide()
            } else {
              itemEl
                .removeClass('closed')
                .find('.glyphicon')
                .removeClass('glyphicon-chevron-right')
                .addClass('glyphicon-chevron-down')
              itemChildrenEl.show()
            } 
          }
        })
      })
    }

    this.init = function() {
      this.render();
      this.trigger();
    }

    return this.init()
  }
})(jQuery);