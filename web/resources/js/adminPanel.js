$(document).ready(function () {
    var control = 0;
    $(".brand").click(function () {
        if (control === 0){
            $(".nav-side-menu").addClass("toggle-bar");
            control++;
        }else{
            $(".nav-side-menu").removeClass("toggle-bar");
            control--;
        }
    });
    
    $(".menu-content").click(function () {
        $(".sub-menu").addClass("collapse");
    });
});