<!DOCTYPE html>
<html lang="en">
<head>
  <title>Page Title</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
    * {
      box-sizing: border-box;
    }

    body {
      font-family: Arial, Helvetica, sans-serif;
      margin: 0;
    }

    /* Style the header */
    .header {
      padding: 220px;
      text-align: center;
      background: #1abc9c;
      color: white;
    }

    /* Increase the font size of the h1 element */
    .header h1 {
      font-size: 40px;
    }

    /* Style the top navigation bar */
    .navbar {
      overflow: hidden;
      background-color: #ffffff;
    }

    /* Style the navigation bar links */
    .navbar a {
      float: left;
      display: block;
      color: #131313;
      text-align: center;
      padding: 14px 20px;
      text-decoration: none;
    }

    /* Right-aligned link */
    .navbar a.right {
      float: right;
    }

    /* Change color on hover */
    .navbar a:hover {
      background-color: #1abc9c;
      color: #131313;
    }


    /* Footer */
    .footer {
      font-size: 12pt;
      padding-bottom: 20px;
      text-align: center;
      color: grey;
    }


    /* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
    @media screen and (max-width: 400px) {
      .navbar a {
        float: none;
        width:100%;
      }
    }
  </style>
</head>
<body>

<div class="navbar">
  <a href="#">Products</a>
  <a href="#">About</a>
  <a href="#">FAQ</a>
  <a href="${pageContext.request.contextPath}/login" class="right">Sign in</a>
  <a href="${pageContext.request.contextPath}/registration" class="right">Sign up</a>
</div>

<div class="header">
  <h1>Online market</h1>
  <p>Quality is when the buyer returns - not the goods</p>
</div>


<div class="footer">
  Developed by Aleksei Smuraha, Halina Shukel, Valeriy Karpov,Yana Vaitovich, Makar Ivanov
</div>

</body>
</html>