<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Track-Stock - Register</title>
     <link rel="icon" type="image/x-icon" href="../src/icon.png">
        <!--Link for Icons-->
        <link
            href="https://cdn.jsdelivr.net/npm/remixicon@3.4.0/fonts/remixicon.css"
            rel="stylesheet"
        />

        <!--Link for Cascading Style sheet(CSS)-->
        <link rel="stylesheet" href="signup.css">

    </head>
    <body>
    <!--login container Section-->
    <div class="login" id="login">
        <div>
            <a href="../Home/index.php"> <img class="login__close" src="../src/close.png"></a>
        </div>
        <form action="../SignUpHandler" class="login__form" method="post" onsubmit="return validInput()">
            <h2 class="login__title">Register Your Account</h2>

            <div class="login__group">
                <div>
                    <label for="username" class="login__label">Username</label>
                    <input
                        type="text"
                        placeholder="Write your Username"
                        id="username"
                        name="username"
                        class="login__input"
                    />
                </div>

                <div>
                    <label for="email" class="login__label">Email</label>
                    <input
                        type="email"
                        placeholder="Enter your Email"
                        id="email"
                        name="email"
                        class="login__input"
                    />
                </div>

                <div>
                    <label for="password" class="login__label">Password</label>
                    <input
                            style="margin-bottom: 30px;"
                        type="password"
                        placeholder="Enter your password"
                        id="password"
                        name="password"
                        class="login__input"
                    />
                </div>


            </div>

            <div>
                <p class="login__signup">Already Have An Account
                     <a href="../Login/Login.jsp"> Sign In</a>
                </p>
                <input
                        id="checkbox"
                        name="check"
                        type="checkbox"
                        class="login__forgot"
                />
                I Agree to <a href="#" >Terms and Conditions</a>
                   <p class="login__forgot"><a href="#">Privacy Policy</a></p>

                <button type="submit" class="login__button" id="submit">Sign Up</button>
            </div>
        </form>
        <div id="alertmsg">

        </div>
    </div>

    <!--Background Image-->
    <main class="main">
        <img src="../src/Background_login.JPG" alt="image" class="main__bg"/>
    </main>

    <!--script for handling errors-->
    <script>

        window.onload = function() {
            checkcred();
            rearm();


            document.querySelector("form").addEventListener("submit", function(event) {

                if (!validInput()) {
                    event.preventDefault();
                } else {
                    document.querySelector("#submit").innerHTML = "Signing In";
                }
            });
        };

        function checkcred() {
            console.log("Checking credentials");
            var signup_Fail = "<?php echo $Signup_Fail ?>";
            console.log(signup_Fail);
            var alertmsg = document.getElementById("alertmsg");
            if (signup_Fail !== '') {
                alertmsg.style.display = "block";
                alertmsg.innerHTML = signup_Fail;
            }
        }

        function rearm() {
            document.querySelector("#submit").innerHTML = "Sign Up";
        }

        function validInput() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var email = document.getElementById("email").value;
            var alertmsg = document.getElementById("alertmsg");
            var checked = document.getElementById("checkbox");

            if (username === '' || password === '' || email === '') {
                alertmsg.style.display = "block";
                alertmsg.innerHTML = "Please Fill out All the Fields";
                return false;
            } else {
                if(checked.checked){
                    alertmsg.style.display = "none";
                    return true;
                }
                else{
                    alertmsg.style.display = "block";
                    alertmsg.innerHTML = "You must agree to terms and conditions";
                }
            }
        }
    </script>

    </body>

    </html>

