<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Result Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            text-align: center;
            margin: 0;
            padding: 0;
        }
        .container {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin: 20px auto;
            width: 300px;
        }
        h1 {
            color: #333;
        }
        .result {
            font-size: 24px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Result</h1>
        <p class="result">Result is: ${result}</p>
    </div>
</body>
</html>
