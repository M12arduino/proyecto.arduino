<%-- 
    Document   : adminPanel
    Created on : 18-may-2016, 14:14:23
    Author     : Couto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div class="nav-side-menu">
    <div class="brand">Panel de administrador</div>
    <div class="menu-list">
        <ul id="menu-content" class="menu-content collapse out">
            <li  data-toggle="collapse" data-target="#products" class="collapsed">
                <a href="#">Chorizos</a>
            </li>
            <ul class="sub-menu collapse" id="products">
                <li><a href="#">Rajoy</a></li>
                <li><a href="#">Albert</a></li>
                <li><a href="#">Pablito</a></li>
                <li><a href="#">Puig</a></li>
                <li><a href="#">Puig</a></li>
            </ul>

            <li data-toggle="collapse" data-target="#service" class="collapsed">
                <a href="#">+ chorizos</a>
            </li>  
            <ul class="sub-menu collapse" id="service">
                <li><a href="#">Rajoy</a></li>
                <li><a href="#">Rajoy</a></li>
                <li><a href="#">Rajoy</a></li>
            </ul>

            <li data-toggle="collapse" data-target="#new" class="collapsed">
                <a href="#">New</a>
            </li>
            <ul class="sub-menu collapse" id="new">
                <li><a href="#">Rajoy</a></li>
                <li><a href="#">Rajoy</a></li>
                <li><a href="#">Rajoy</a></li>
            </ul>
        </ul>
    </div>
</div>