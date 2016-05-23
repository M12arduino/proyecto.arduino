 $(document).ready(function () {
    var control = 0;
    $(".panel-title").click(function () {
        if (control === 0){
            $( ".menu-content" ).hide();
            $("#panel-title").html("<img src='/A_Spring_Inicial/resources/img/control_panel.png'>");
            $("#panel-title").removeClass("panel-title");
            $("#panel-title").addClass("nav-bar-colapsed");
            $("#admin-panel").addClass("admin-panel-colapsed");
            control++;
        }else{
            $( ".menu-content" ).show();
            $("#admin-panel").removeClass("admin-panel-colapsed");
            $("#panel-title").removeClass("nav-bar-colapsed");
            $("#panel-title").addClass("panel-title");
            $("#panel-title").html("Panel de administrador");
            control--;
        }
    });
    
    $(".menu-content").click(function () {
        $(".sub-menu").addClass("collapse");
    });
});