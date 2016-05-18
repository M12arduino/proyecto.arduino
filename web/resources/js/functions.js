/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


  function prepareForm(selector, url){
        var action =$(selector).attr("action")
        $(selector).attr("action",action+"/"+url)
    }
    
  function getBasePath(){
      var str = window.location.pathname;
      return "/"+str.split("/")[1]+"/";
      
  }