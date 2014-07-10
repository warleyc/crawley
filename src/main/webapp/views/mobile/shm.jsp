<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Crawley.fr > SHM</title>
<jsp:include page="/views/includes/head_mobile.jsp" />
</head>
<body>
	<div data-role="page" id="page1">
		<div data-theme="b" data-role="header">
			<a href="/mobile/index.do" data-icon="home" data-iconpos="notext"
				data-direction="reverse">Home</a>
			<jsp:include page="/views/includes/lang_mobile.jsp" />
			<h3>SHM</h3>
		</div>

		<div id="canvas">
			<canvas width='300' height='300' id='logo'>
				This text is displayed because your browser does not support HTML5 Canvas.
				Change your browser ! use the last version of chrome or firefox.
			</canvas>
		</div>
		<jsp:include page="/views/includes/footer_mobile.jsp" />
	</div>
	<jsp:include page="/views/includes/fw_mobile.jsp" />
	<script type="text/javascript" src="/js/logo.js"></script>
</body>
</html>