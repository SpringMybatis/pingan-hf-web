<html>
<head>
	<title>dwr</title>
	<script type="text/javascript" ></script>
	<script type="text/javascript" src="/test/dwr/engine.js"></script>
    <script type="text/javascript" src="/test/dwr/util.js"></script>
    <script type="text/javascript" src="/test/dwr/interface/helloService.js"></script>
    <script type="text/javascript">
    
    	console.info(helloService);
    
		function getDataFromServer() {
			helloService.getUser({
			    callback: getDataFromServerCallBack
			});
		}
		
		function getDataFromServerCallBack(dataFromServer) {
			console.info(dataFromServer);
		}
		
		function printUser(params){
			console.info(params);
		}
		
		getDataFromServer();
    
    </script>
</head>
<body>
<h2>Hello World!</h2>
<a>http://blog.csdn.net/hhl2046/article/details/50008493</a>
<a>http://blog.csdn.net/pangliang_csdn/article/details/68945872</a>
</body>
</html>
