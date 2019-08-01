//更多精品Bootstrap模板请访问：http://www.bootstrapmb.com
(function ($) {
  "use strict";

  var $document = $(document),
    $window = $(window),
    $body = $('body'),
    $ttHeader = $('header'),

    /* menu setting*/
    header_menu_timeout = 200,
    header_menu_delay = 200,

    //header
    //header menu
    $ttDesctopMenu = $ttHeader.find('.tt-desctop-menu');


  function doAnimations(elements) {
    var animationEndEvents = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
    elements.each(function () {
      var $this = $(this);
      var $animationDelay = $this.data('animation-delay');
      var $animationType = 'animated ' + $this.data('animation');
      $this.css({
        'animation-delay': $animationDelay,
        '-webkit-animation-delay': $animationDelay
      });
      $this.addClass($animationType).one(animationEndEvents, function () {
        $this.removeClass($animationType);
      });
      if ($this.hasClass('animate')) {
        $this.removeClass('animation');
      }
    });
  };

  var tooltip = {
    html_i: '#tt-tooltip-popup',
    html_s: '<div id="tt-tooltip-popup"><span>',
    html_e: '</span><i></i></div>',
    tp_attr: '[data-tooltip]',
    tp_mod: false,
    init: function () {
      this.tp_mod = this.get_tp_mod();
      if (!this.tp_mod.length || /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) return false;
      this.handler();
    },
    get_tp_attr: function () {
      return this.tp_attr;
    },
    get_tp_mod: function () {
      return $(this.get_tp_attr());
    },
    get_w_width: function () {
      return window.innerWidth || $window.width();
    },
    get_html_obj: function (name) {
      return this.html_s + name + this.html_e;
    },
    check_pr_page_swatches: function ($obj) {
      var swc = $obj.closest('.tt-swatches-container');
      var search = $obj.closest('.tt-search');
      var qv = $obj.closest('.tt-btn-quickview');
      var cc = $obj.closest('.tt-collapse-content');
      var wl = $obj.closest('.wlbutton-js');
      if (!swc.length && !search.length && !qv.length && !cc.length && !wl.length) return false;
      return true;
    },
    handler: function () {
      var _ = this;
      $('body').on('mouseenter mouseleave', this.get_tp_attr(), function (e) {
        var ww = _.get_w_width();
        if (ww <= 1024) return false;

        if (e.type === 'mouseenter') _.onHover($(this));
        if (e.type === 'mouseleave') _.offHover($(this));
      });
    },
    onHover: function ($obj) {
      var _ = this,
        value = $obj.attr('data-tooltip'),
        $o = $(this.get_html_obj(value)),
        tposition = $obj.attr('data-tposition'),
        ftag = $obj.attr('data-findtag');

      if (value == "") return false;

      $body.append($o);

      var $objforsize = typeof ftag != 'undefined' ? $obj.find(ftag).first() : $obj,
        th = $o.innerHeight(),
        tw = $o.innerWidth(),
        oh = $objforsize.innerHeight(),
        ow = $objforsize.innerWidth(),
        v = $objforsize.offset().top,
        h = $objforsize.offset().left;

      tposition = typeof tposition != 'undefined' ? tposition : 'top';

      if (tposition == 'top') {
        v += -th - 20;
        h += parseInt((ow - tw) / 2);
      }
      if (tposition == 'bottom') {
        v += oh + 24;
        h += parseInt((ow - tw) / 2);
      }
      if (tposition == 'left') {
        v += parseInt((oh - th) / 2);
        h += -tw - 24;
      }
      if (tposition == 'right') {
        v += parseInt((oh - th) / 2);
        h += ow + 24;
      }

      this.showTooltip($o, h, v, tposition);

      if (!this.check_pr_page_swatches($obj)) return false;
      $obj.on('click.closeTooltip', function () {
        _.offHover($(this));
        $(this).unbind("click.closeTooltip");
      })
    },
    offHover: function ($obj) {
      $body.find(this.html_i).remove();

      if (!this.check_pr_page_swatches($obj)) return false;
      $obj.unbind("click.closeTooltip");
    },
    showTooltip: function ($o, h, v, tposition) {
      var a = {
          opacity: 1
        },
        k = tposition;
      if (k == 'bottom') k = 'top';
      if (k == 'right') k = 'left';

      a[k] = tposition == 'bottom' || tposition == 'right' ? '-=10px' : '+=10px';

      $o.css({
        'top': v,
        'left': h
      }).addClass('tooltip-' + tposition).animate(a, 200);
    }
  }
  // tooltip
  tooltip.init();

  // header - tt-dropdown-obj
  ttHeaderDropdown();

  function ttHeaderDropdown() {
    var dropdownPopup = $('.header-popup-bg');
    if (!dropdownPopup.length) {
      $body.append('<div class="header-popup-bg"></div>');
    };
    $('header').on('click', '.tt-dropdown-obj', function (e) {
      var ttwindowWidth = window.innerWidth || $window.width(),
        $this = $(this),
        target = e.target,
        objSearch = $('.tt-search'),
        objSearchInput = objSearch.find('.tt-search-input');

      // search
      if ($this.hasClass('tt-search') && $('.tt-dropdown-toggle').is(target)) {
        searchPopup();
      };

      function searchPopup() {
        $this.addClass('active');
        objSearchInput.focus();
        return false;
      };
      if (objSearch.find('.tt-btn-close').is(target)) {
        objSearchClose();
        return false;
      };

      function objSearchClose() {
        $this.removeClass('active');
        objSearchInput.blur();
        return false;
      };

      // cart, account, multi-ob
      if (!$(this).hasClass('tt-search') && $('.tt-dropdown-toggle').is(target)) {
        ttwindowWidth <= 1024 ? popupObjMobile($this) : popupObjDesctop($this);
      };

      function popupObjMobile(obj) {
        $('header').find('.tt-dropdown-obj.active').removeClass('active');
        obj.toggleClass('active').find('.tt-dropdown-menu').removeAttr("style");
        $body.toggleClass('tt-popup-dropdown');
      };

      function popupObjDesctop(obj) {
        var $this = obj,
          target = e.target;

        if ($this.hasClass('active')) {
          $this.toggleClass('active').find('.tt-dropdown-menu').slideToggle(200);
          return;
        };
        $('.tt-desktop-header .tt-dropdown-obj').each(function () {
          var $this = $(this);
          if ($this.hasClass('active')) {
            $this.removeClass('active').find('.tt-dropdown-menu').css("display", "none");
          }
        });
        if ($('.tt-dropdown-toggle').is(target)) {
          toggleDropdown($this);
        };
      };

      function toggleDropdown(obj) {
        obj.toggleClass('active').find('.tt-dropdown-menu').slideToggle(200);
      };

      $(document).mouseup(function (e) {
        var ttwindowWidth = window.innerWidth || $window.width();

        if (!$this.is(e.target) && $this.has(e.target).length === 0) {
          $this.each(function () {
            if ($this.hasClass('active') && $this.hasClass('tt-search')) {
              objSearch.find('.tt-btn-close').trigger('click');
            };
            if ($this.hasClass('active') && !$this.hasClass('tt-search')) {
              if (ttwindowWidth <= 1024) {
                closeObjPopupMobile();
              } else {
                $('.tt-dropdown-obj').each(function () {
                  if ($(this).hasClass('active')) {
                    $(this).removeClass('active').find('.tt-dropdown-menu').css("display", "none");
                  }
                });
              };
            };
          });
        };
        if ($this.find('.tt-mobile-add .tt-close').is(e.target)) {
          closeObjPopupMobile();
        };
      });

      function closeObjPopupMobile() {
        $('.tt-dropdown-obj.active').removeClass('active');
        $body.removeClass('tt-popup-dropdown');
        return false;
      };
    });
  };

  /*
    header menu
  */
  // header menu(hover)
  (function toggle_header_menu() {
    var delay = header_menu_timeout,
      hoverTimer = header_menu_delay,
      timeout1 = false;

    var set_dropdown_maxH = function () {
      var wind_H = window.innerHeight,
        $ttDesctopMenu = $(this).find('.dropdown-menu'),
        menu_top = $ttDesctopMenu.get(0).getBoundingClientRect().top,
        menu_max_H = wind_H - menu_top,
        $ttDesctopMenu_H = $ttDesctopMenu.innerHeight();

      if ($ttDesctopMenu_H > menu_max_H) {
        var $body = $('body');
        $ttDesctopMenu.css({
          maxHeight: menu_max_H - 20,
          overflow: 'auto'
        });

        var scrollWidth = function () {
          var $div = $('<div>').css({
            overflowY: 'scroll',
            width: '50px',
            height: '50px',
            visibility: 'hidden'
          });

          $body.append($div);
          var scrollWidth = $div.get(0).offsetWidth - $div.get(0).clientWidth;
          $div.remove();

          return scrollWidth;
        };

        $body.css({
          overflowY: 'hidden',
          paddingRight: scrollWidth()
        });
      }
    };

    if ($ttDesctopMenu.length > 0) {
      $('.tt-megamenu-submenu li a').each(function () {
        if ($(this).find('img').length) {
          $(this).closest('ul').addClass('tt-sub-img');
        }
      });

      $ttDesctopMenu.find('.dropdown-menu').each(function () {
        if ($(this).length) {
          $(this).closest('.dropdown').addClass('tt-submenu');
        }
      });

      $(document).on({
        mouseenter: function () {

          var $this = $(this),
            that = this,
            windowW = window.innerWidth || $(window).width();

          if (windowW > 1025 && $body.hasClass('touch-device')) {
            $ttDesctopMenu.find('.dropdown.tt-submenu > a').one("click", false);
          };

          timeout1 = setTimeout(function () {

            var $ttDesctopMenu = $this.find('.dropdown-menu');


            $this.addClass('active')
              .find(".dropdown-menu")
              .stop()
              .addClass('hover')
              .fadeIn(hoverTimer);

            if ($ttDesctopMenu.length & !$ttDesctopMenu.hasClass('one-col')) {
              set_dropdown_maxH.call(that);
            }

          }, delay);

        },
        mouseleave: function (e) {
          var $this = $(this),
            $dropdown = $this.find(".dropdown-menu");

          if ($(e.target).parents('.dropdown-menu').length && !$(e.target).parents('.tt-megamenu-submenu').length && !$(e.target).parents('.one-col').length) return;

          if (timeout1 !== false) {
            clearTimeout(timeout1);
            timeout1 = false;
          }

          if ($dropdown.length) {
            $dropdown.stop().fadeOut({
              duration: 0,
              complete: function () {
                $this.removeClass('active')
                  .find(".dropdown-menu")
                  .removeClass('hover');
              }
            });
          } else {
            $this.removeClass('active')
              .find(".dropdown-menu")
              .removeClass('hover');
          }

          $dropdown.removeAttr('style');

          $body.removeAttr('style');
        }
      }, '.tt-desctop-menu li');

      $ttDesctopMenu.find('.multicolumn ul li').on('hover', function () {
        var $ul = $(this).find('ul:first');

        if ($ul.length) {
          var windW = window.innerWidth,
            windH = window.innerHeight,
            ulW = parseInt($ul.css('width'), 10),
            thisR = this.getBoundingClientRect().right,
            thisL = this.getBoundingClientRect().left;

          if (windW - thisR < ulW) {
            $ul.removeClass('left').addClass('right');
          } else if (thisL < ulW) {
            $ul.removeClass('right').addClass('left');
          } else {
            $ul.removeClass('left right');
          }
          $ul.stop(true, true).fadeIn(300);
        }
      }, function () {
        $(this).find('ul:first').stop(true, true).fadeOut(300).removeAttr('style');
      });


      $ttDesctopMenu.find('.tt-megamenu-submenu li').on("mouseenter", function () {
        var $ul = $(this).find('ul:first');
        if ($ul.length) {
          var $dropdownMenu = $(this).parents('.dropdown').find('.dropdown-menu'),
            dropdown_left = $dropdownMenu.get(0).getBoundingClientRect().left,
            dropdown_Right = $dropdownMenu.get(0).getBoundingClientRect().right,
            dropdown_Bottom = $dropdownMenu.get(0).getBoundingClientRect().bottom,
            ulW = parseInt($ul.css('width'), 10),
            thisR = this.getBoundingClientRect().right,
            thisL = this.getBoundingClientRect().left;

          if (dropdown_Right - 20 - thisR < ulW) {
            $ul.removeClass('left').addClass('right');
          } else if (thisL - ulW - 20 < dropdown_left) {
            $ul.removeClass('right').addClass('left');
          } else {
            $ul.removeClass('left right');
          }

          $ul.stop(true, true).delay(150).fadeIn(300);

          var ul_bottom = $ul.get(0).getBoundingClientRect().bottom;

          if (dropdown_Bottom < ul_bottom) {
            var move_top = dropdown_Bottom - ul_bottom;
            $ul.css({
              top: move_top
            });
          }
        }
      }).on('mouseleave', function () {
        $(this).find('ul:first').stop(true, true).fadeOut(300).removeAttr('style');
      });

      $ttDesctopMenu.find('.dropdown div').on('hover', function () {
        $(this).children('.tt-title-submenu').toggleClass('active');
      });

    };

    function onscroll_dropdown_hover() {
      var $dropdown_active = $('.dropdown.hover');

      if (!$dropdown_active.find('.dropdown-menu').not('.one-col').length) return;

      if ($dropdown_active.length)
        set_dropdown_maxH.call($dropdown_active);
    };
    $(window).on('scroll', function () {
      onscroll_dropdown_hover();
    });
  })();
})(jQuery);