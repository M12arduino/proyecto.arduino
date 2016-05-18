/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("#searchId").on("click",function(){
        
        $.ajax({
            url:getBasePath()+"robot/buscar.htm",
            
        })
    })
})

