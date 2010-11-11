<%@ taglib prefix="cms" uri="cms-taglib"%>
<%@ taglib prefix="cmsu" uri="cms-util-taglib"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="padding-left:10px;">
	<cms:editBar editLabel="Edit Comment Paragraph" />
	<div id='fb-root'></div>
	<script>
		window.fbAsyncInit = function() {
		FB.init({appId: "${content.applicationID}", status: true, cookie: true,
		xfbml: true});
		};
		(function() {
			var e = document.createElement("script");
			e.async = true;
			e.src = "http://connect.facebook.net/en_US/all.js";
			e.async = true;
			document.getElementById("fb-root").appendChild(e);
		}());
	</script>
	<fb:comments>
	<fb:title><strong>${content.title}</strong></fb:title><br/><br/>
	</fb:comments>
</div>