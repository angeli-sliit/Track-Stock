<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="java.util.Random"%>
<%@page import="java.util.Properties"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession se1 = request.getSession();
    String otp = (String) se1.getAttribute("OTP");
    String verifiedEmail = (String) se1.getAttribute("verifiedEmail");
    boolean otpSet = (otp != null);
    boolean emailSet = (verifiedEmail != null);
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Track-Stock - Reset Password</title>
    <link rel="icon" type="image/x-icon" href="../src/icon.png">
    <!-- Link for Icons -->
    <link href="https://cdn.jsdelivr.net/npm/remixicon@3.4.0/fonts/remixicon.css" rel="stylesheet" />
    <!-- Link for Cascading Style Sheet (CSS) -->
    <link rel="stylesheet" href="add_email.css">
    <style>
        #otpDiv, #pass {
            display: none;
        }
    </style>
</head>

<body>
    <!-- Login Container Section -->
    <div class="login" id="login">
        <form action="../forgetpass1Handler" class="login__form" id="resetForm" method="post">
            <h2 class="login__title">Reset Your Password</h2>
            <div class="login__group">
                <div>
                    <label for="Email" class="login__label">Enter Your Email</label>
                    <input type="email" placeholder="Write your Email" id="email" name="email" class="login__input" />
                    <button id="ffrombtn" type="button" class="login__button1" onclick="validate()">Submit</button>
                </div>
                <div id="alertmsg"></div>
            </div>
            <div id="otpDiv">
                <label for="OTP" class="login__label">OTP</label>
                <input type="text" placeholder="Enter your OTP" id="OTP" name="OTP" class="login__input" />
                <p class="login__signup">Didn't Receive a code ?
                    <a href="#">Resend OTP</a>
                </p>
                <button type="button" class="login__button1" onclick="validateOTP()">Verify</button>
            </div>
            <div class="thirdone" id="pass">
                <label for="newpassword" class="login__label">New Password</label>
                <input type="password" placeholder="Enter your Password" id="password" name="password" class="login__input" />
                <div>
                    <button type="button" class="login__button_end" onclick="submitsecond()">Change Password</button>
                </div>
            </div>
        </form>
    </div>

    <!-- Separate form to submit the new password -->
    <form action="../updatepassword" method="post" id="secondform">
        <input type="hidden" id="newPassword" name="newPassword" />
    </form>

    <!-- Background Image -->
    <main class="main">
        <img src="../src/Background_login.JPG" alt="image" class="main__bg" />
    </main>

    <script>
        function validate() {
            if (document.getElementById("email").value === "") {
                let msg = document.getElementById("alertmsg");
                msg.style.display = "block";
                msg.innerHTML = "Please Enter Your Email";
            } else {
                document.getElementById("resetForm").submit();
            }
        }

        function validateOTP() {
            const otpInput = document.getElementById("OTP").value;
            const sessionOTP = "<%= otp %>";

            if (otpInput === sessionOTP) {
                document.getElementById('pass').style.display = 'block';
            } else {
                alert("Invalid OTP");
            }
        }

        function submitsecond() {
            // Get the password value from the input field
            const newPassword = document.getElementById("password").value;

            // Set this value in the hidden form field
            document.getElementById("newPassword").value = newPassword;

            // Submit the second form to update the password
            document.getElementById("secondform").submit();
        }

        window.onload = function () {
            var otpSet = <%= otpSet %>;
            var emailSet = <%= emailSet %>;

            if (otpSet && emailSet) {
                document.getElementById('otpDiv').style.display = 'block';
            }
        };
    </script>
</body>

</html>
