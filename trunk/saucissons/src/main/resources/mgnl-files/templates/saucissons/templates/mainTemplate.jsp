<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/docroot/saucissons/favicon.ico" />
	<title>${content.title}</title>
	<meta name="description" content="${content.metaDescription}" />
	<meta name="keywords" content="${content.metaKeywords}" />
	<link href="${pageContext.request.contextPath}/docroot/saucissons/css/styles.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/docroot/saucissons/css/fullcalendar.css"  rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/docroot/saucissons/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/docroot/saucissons/js/jquery-ui-custom.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/docroot/saucissons/js/fullcalendar.min.js"></script>
</head>

<body>
	<div id="content">
		<cms:mainBar paragraph="saucisson-main-dialog" label="Page Properties"/>
		
		<!-- Sides -->
		<cms:loadPage path="/saucissons/produits/presentation"/>
		<div class="side left">
			<cms:adminOnly>
				<br/>
			</cms:adminOnly>
			<cms:newBar contentNodeCollectionName="LeftSideParagraphs"
				paragraph="image-paragraph" newLabel="Add Image to side" />
			<cms:contentNodeIterator contentNodeCollectionName="LeftSideParagraphs">
				<cms:includeTemplate />
			</cms:contentNodeIterator>
		</div>
		<div class="side right">
			<cms:adminOnly>
				<br/>
			</cms:adminOnly>
			<cms:newBar contentNodeCollectionName="RightSideParagraphs"
				paragraph="image-paragraph" newLabel="Add Image to side" />
			<cms:contentNodeIterator contentNodeCollectionName="RightSideParagraphs">
				<cms:includeTemplate />
			</cms:contentNodeIterator>
		</div>
		<cms:unloadPage/>
		
		<!-- Content begins -->
		<div id="main">
			<div id="right">
				<div id="righttop"></div>
				<jsp:include page="common/content.jsp" />
			</div>
			<div id="left">
				<div id="header" class="black">
					<a href="${pageContext.request.contextPath}/">
						<img src="${pageContext.request.contextPath}/docroot/saucissons/images/cochon.jpg"/>
					</a>
				</div>
				<jsp:include page="common/menu.jsp" />
			</div>
			<div id="mainbot"></div>
		</div>
		
		<!--Footer begins -->
		<div id="footer">
			<jsp:include page="common/footer.jsp" />
		</div>
	</div>
</body>

</html>