<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="cmsfn" uri="http://www.magnolia.info/tlds/cmsfn-taglib.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/docroot/saucissons/favicon.ico" />
	
	<meta name="description" content="${content.metaDescription}" />
	<meta name="keywords" content="${content.metaKeywords}" />
	
	<link href="${pageContext.request.contextPath}/docroot/saucissons/css/styles.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/docroot/saucissons/css/carousel.css"  rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/docroot/saucissons/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/docroot/saucissons/js/jquery-ui-custom.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/docroot/saucissons/js/jquery.infinitecarousel.js"></script>
	
	<title>${content.title}</title>
</head>

<body>
<cms:mainBar paragraph="saucisson-main-dialog" label="Page Properties"/>

	<table width="100%"><tr>
	<!-- Left Side -->
	<td valign="top">
		<cms:loadPage path="/saucissons/produits/presentation"/>
		<div class="side left">
			<cms:adminOnly>
				<br/><br/>
			</cms:adminOnly>
			<cms:newBar contentNodeCollectionName="LeftSideParagraphs"
				paragraph="image-paragraph" newLabel="Add Image to side" />
			<cms:contentNodeIterator contentNodeCollectionName="LeftSideParagraphs">
				<cms:includeTemplate />
			</cms:contentNodeIterator>
		</div>
		<cms:unloadPage/>
	</td>
	
	<td width="989px">
	<div id="content">
		<!-- Content begins -->
		<div id="main">
			<div id="right">
				<div id="righttop"></div>
				<jsp:include page="common/content.jsp" />
			</div>
			<div id="left">
				<div id="header" class="black">
					<div style="float:left;margin-left:35px;margin-top:10px;">
						<a href="${pageContext.request.contextPath}/">
							<img src="${pageContext.request.contextPath}/docroot/saucissons/images/cochon.jpg"/>
							<br/>
							<span style='font-size: 15px; font-family: "Script MT Bold"; color: white; font-style: italic; language: fr'>Comme &#224; la maison... </span>
						</a>
					</div>
					<div style="float:right;padding-right:25px;margin-top: 90px;">
						<a href="${pageContext.request.contextPath}/en${cmsfn:currentPage().handle}">
							<img src="${pageContext.request.contextPath}/docroot/saucissons/images/flags/au.png"/>
						</a>
						<br/>
						<a href="${pageContext.request.contextPath}/fr${cmsfn:currentPage().handle}">
							<img src="${pageContext.request.contextPath}/docroot/saucissons/images/flags/fr.png"/>
						</a>
					</div>
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
	</td>
	
	<!-- Right Side -->
	<td valign="top">
	<cms:loadPage path="/saucissons/produits/presentation"/>
	<div class="side right">
			<cms:adminOnly>
				<br/><br/>
			</cms:adminOnly>
			<cms:newBar contentNodeCollectionName="RightSideParagraphs"
				paragraph="image-paragraph" newLabel="Add Image to side" />
			<cms:contentNodeIterator contentNodeCollectionName="RightSideParagraphs">
				<cms:includeTemplate />
			</cms:contentNodeIterator>
		</div>
		<cms:unloadPage/>
	</td>
	</tr></table>
</body>

</html>