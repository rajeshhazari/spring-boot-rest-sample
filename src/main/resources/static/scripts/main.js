$(document).ready(function(){

  // jQuery methods go here...

/*
$.ajaxSetup({
  headers: {
    'Authorization': "Basic " + getBasicAuthToken(user,password)
  }
});
*/


$(function(){
  $('a').each(function(){
      if ($(this).prop('href') == window.location.href) {
          $(this).addClass('active text-white'); $(this).parents('li').addClass('active');
      }
  });
});
Cookies.set('client_timezone', Intl.DateTimeFormat().resolvedOptions().timeZone, { path: '/' });

function getBasicAuthToken (user, password) {
  var tok = btoa(user + ':' + password);
  var hash = "Basic "+ hash;
  return hash;
}

$.ajaxSetup({
  headers: {
    'Authorization': getBasicAuthToken('rajraspiadm','Tanushg!@#8579')
  }
});


if($("input#username").val()){
  var username = $("input#username").val();
}
if($("input#password").val()){
  var password = $("input#password").val();
}
var authToken = window.sessionStorage.getItem('authToken');



var CurrentUrl= document.URL;
var CurrentUrlEnd = CurrentUrl.split('/').filter(Boolean).pop();
    console.log(CurrentUrlEnd);

 /*
 $("a#boxBarnowl11").click(function(e){
    $("e").before("<b>Before</b>");
  });

  $("a#boxBarnowl11").click(function(e){
    e.after("<i>After</i>");
  });

*/
$("#boxBarnowl #owly").click(function(e){
    openImgDialog(e)
  });


function openImgDialog(e) {
  var ele = $('<a  href=""  class="lightbox" id="boxBarnowlidOverLay">');               // Create element with HTML 
  //var txt2 = $("<p></p>").text("Text.");   // Create with jQuery
  //var txt3 = document.createElement("p");  // Create with DOM
  //txt3.innerHTML = "Text.";
  var imgEle = $('<img id="imgModal">')
      imgEle.attr('src',e.target.getAttribute('src'));
      imgEle.attr('alt',e.target.getAttribute('alt'));    
  ele.append(imgEle)
  ele.show('slow')
  $("main").append(ele);

}

$("a#boxBarnowlidOverlay").click(function(e){
  $("#boxBarnowlidOverlay").remove();
});




function setActive(e) {
  linkObj = document.getElementById('premier-topnav').getElementsByTagName('a');
  for(i=0;i<linkObj.length;i++) { 
    if(document.location.href.indexOf(linkObj[i].href)>=0) {
      linkObj[i].classList.add("active");
    }
  }
}

function setEleActive(e){
//    e.target.removeClass('invisibile')
    console.log('e setEleActive called')
    $(e).removeClass('invisibile');
    $(this).siblings().removeClass('choice');

}


function activateTab(e){
  $('.navbar-nav .nav-item a[href="#' + tab + '"]').removeClass('invisible');
};




 // below are all function collected from web stackoverflow that are not used            
$(function(){
  var current = location.pathname;
  $('#nav li a').each(function(){
      var $this = $(this);
      // if the current path is like this link, make it active
      if($this.attr('href').indexOf(current) !== -1){
          $this.removeClass('invisible');
      }
  })
});

//document.querySelector(`a[href^='${location.pathname.split('/'[1])}']`).className = 'active'
$( "nav ul li a").each(function() {
        var ThisUrl = $(this).attr('href');
        var ThisUrlEnd = ThisUrl.split('/').filter(Boolean).pop();
        if(ThisUrlEnd == CurrentUrlEnd)
        $(this).removeClass('active')
      });



  // Get the text field that we're going to track
  //let field = document.getElementById("sttTextArea");

  // See if we have an autosave value
  // (this will only happen if the page is accidentally refreshed)
  /*
  if (sessionStorage.getItem("autosave")) {
    // Restore the contents of the text field
    field.value = sessionStorage.getItem("autosave");
  }
  */

  // Listen for changes in the text field
  /*
  field.addEventListener("change", function() {
    // And save the results into the session storage object
    sessionStorage.setItem("autosave", field.value);
  });
  */

}); 