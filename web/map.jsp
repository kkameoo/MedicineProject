<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-06-23
  Time: 오후 5:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
</head>
<body>
<div id="map" style="width:100%;height:100vh;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4496655315afe9a889abb090aaeb7014"></script>
<script>
  var mapContainer = document.getElementById('map'),
          mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667),
            level: 3
          };
  var map = new kakao.maps.Map(mapContainer, mapOption);
</script>

<script>
    const jsonData = require('./json/store1.json');
    console.log(jsonData);
</script>
</body>
</html>
