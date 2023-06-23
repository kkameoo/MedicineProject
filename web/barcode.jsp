<%@ page import="org.w3c.dom.Document" %>
<%@ page import="org.jsoup.Jsoup" %>
<%@ page import="org.jsoup.select.Elements" %>
<%@ page import="org.w3c.dom.Element" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-06-23
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="chrome">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrap.com/bootstrap/3.4.1//js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/html5-qrcode@2.0.9/dist/html5-qrcode.min.js"></script>
    <link rel = "stylesheet" href="css/qr_barcode_scanner.css" />

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <br>
            <center><div id="qr-reader" style="width: 600px; text-align:center"></div></center>
        </div>
    </div>
</div>
<script>
    var result;

    function onScanSuccess(decodedText, decodedResult) {
        console.log(`Code scanned = ${decodedText}`, decodedResult);
        result = decodedResult;
    }
    var html5QrcodeScanner = new Html5QrcodeScanner(
        "qr-reader", { fps: 10, qrbox: 250 });
    html5QrcodeScanner.render(onScanSuccess);

    var outputElement  = document.getElementById("output");
    var message = "Hello, world";
    outputElement.innerText = message;

</script>

</body>
</html>
