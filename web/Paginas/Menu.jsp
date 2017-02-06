<%-- 
    Document   : Menu
    Created on : 3/fev/2017, 13:00:49
    Author     : Adelino Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Twitter Bootstrap 3 Accordion Menu Example</title>
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css" />

        <style type="text/css">
            .panel-title > a:hover,
            .panel-title > a:active,
            .panel-title > a:focus {
                text-decoration: none;
                outline: none;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#one">CSS Tutorials</a>
                                </h4>
                            </div>
                            <div id="one" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <ol>
                                        <li><a href="http://www.kodingmadesimple.com/2014/02/how-to-create-round-social-media-icon.html">How to Create Round Social Media icon style buttons using CSS</a></li>
                                        <li><a href="http://www.kodingmadesimple.com/2014/05/create-css-buttons-step-by-step-tutorial.html">Create CSS Buttons - A Step-by-Step Tutorial</a></li>
                                        <li><a href="http://www.kodingmadesimple.com/2014/03/how-to-add-photo-frame-effect-to-images.html">How to add Photo Frame Effect to Images using pure CSS</a></li>
                                        <li><a href="http://www.kodingmadesimple.com/2014/03/10-amazing-css-drop-cap-effects.html">10 Amazing CSS Drop Cap Effects you can Copy Paste</li></a>
                                        <li><a href="http://www.kodingmadesimple.com/2014/05/create-horizontal-menu-bar-with-html-and-css.html">Create a stylish Horizontal Menu Bar with HTML and CSS</a></li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#two">Bootstrap Tutorials</a>
                                </h4>
                            </div>
                            <div id="two" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ol>
                                        <li><a href="http://www.kodingmadesimple.com/2014/04/bootstrap-custom-responsive-navbar-tutorial.html">Create RESPONSIVE Navigation Menu Bar with Twitter Bootstrap3</a></li>
                                        <li><a href="http://www.kodingmadesimple.com/2014/06/integrate-twitter-bootstrap3-with-codeigniter-framework.html">How to integrate Twitter Bootstrap 3 with PHP CodeIgniter Framework</a></li>
                                        <li><a href="http://www.kodingmadesimple.com/2014/07/add-and-customize-twitter-bootstrap3-breadcrumbs.html">How to Add and Customize Twitter Bootstrap3 Breadcrumbs</a></li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#three">PHP Tutorials</a>
                                </h4>
                            </div>
                            <div id="three" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ol>
                                        <li><a href="http://www.kodingmadesimple.com/2014/08/how-to-get-status-code-from-http-response-headers-in-php.html">How to get the Status Code from HTTP Response Headers in PHP</a></li>
                                        <li><a href="http://www.kodingmadesimple.com/2014/04/php-json-decode-function-to-parse-json-object.html">Use PHP json_decode function to parse json object and insert into MySQL Database</a></li>
                                        <li><a href="http://www.kodingmadesimple.com/2014/04/use-php-preg-match-function-for-form-validation.html">How to use PHP PREG MATCH function to validate Form Input</a></li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/jquery-1.10.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
