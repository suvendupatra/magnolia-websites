<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="shortcut icon" href="favicon.ico" />
	<title>${content.title}</title>
	<meta name="description" content="${content.metaDescription}" />
	<meta name="keywords" content="${content.metaKeywords}" />
	<link href="${pageContext.request.contextPath}/docroot/magnolia-saucisson/css/styles.css" rel="stylesheet" type="text/css" />
</head>

<body class="black">
	<div class="index">
		<cms:mainBar paragraph="saucisson-main-dialog" label="Page Properties"/>
		<br/><br/><br/>
		<a href="${pageContext.request.contextPath}/saucissons/produits/presentation">
			<img height="360" border="0" width="564" src="${pageContext.request.contextPath}/docroot/magnolia-saucisson/images/image377.jpg">
		</a><br/>
		<p class=index style='text-align:center;text-align:center'>
			<span style='font-size:36.0pt;font-family:"Script MT Bold";color:white;font-style:italic;language:fr'>
				Comme &#224; la maison...
			</span>
		</p>
	</div>
</body>

</html>