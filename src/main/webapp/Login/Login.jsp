<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- error handling part-->
<?php
session_start();

if (isset($_SESSION['login_error'])) {
    $loginFail = $_SESSION['login_error'];
    unset($_SESSION['login_error']);
} else {
    $loginFail = "";
}

?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Track-Stock - Login</title>
     <link rel="icon" type="image/x-icon" href="../src/icon.png">
    <!--Link for Icons-->
    <link
        href="https://cdn.jsdelivr.net/npm/remixicon@3.4.0/fonts/remixicon.css"
        rel="stylesheet"
    />

    <!--Link for Cascading Style sheet(CSS)-->
    <link rel="stylesheet" href="signin.css">

</head>
<body>

<!--this for Error message for displaying carrying error message-->
<script>
    function checkcred() {
        var loginFail = "<?php echo $loginFail ?>";
        var alertmsg = document.getElementById("alertmsg");
        if (loginFail !== '') {
            alertmsg.style.display = 'block';
            alertmsg.innerHTML = loginFail;
        }
    }
    document.addEventListener('DOMContentLoaded', function() {
        checkcred();
    });
</script>


<div class="login" id="login">
    <div>
       <a href="../Home/index.php"> <img class="login__close" src="../src/close.png"></a>
    </div>
    <form action="../SigninHandler" class="login__form"  id="loginform" method="post" onsubmit="return validInput()">
        <h2 class="login__title">Sign In</h2>

        <div class="login__group">
            <div>
                <label for="email" class="login__label">Email</label>
                <input
                    type="text"
                    placeholder="Write your email"
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
            <p class="login__signup">
                I Don't have an Account <a href="../Register/Register.jsp">Sign Up</a>
            </p>
            <div id="alertmsg">

            </div>

            <a href="../forgetpass/forgetpass.jsp" class="login__forgot"> forgot your password ? </a>

            <button type="submit" id="login-btn" class="login__button"><span id="login-text">Sign In</span></button>

        </div>
    </form>

</div>

<!--Background Image-->
<main class="main">
    <img src="../src/Background_login.jpeg" alt="image" class="main__bg"/>
</main>
<script src="signin.js"></script>
</body>

</html>
    