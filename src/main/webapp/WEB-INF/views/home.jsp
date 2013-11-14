<html>
<head>
<title>Home</title>
<%@ taglib prefix="hello" uri="../hello.tld"%>
</head>
<body>
	<h1>ようこそHomeページへ !</h1>
	<p>現在時刻は「 ${date}」です。</p>
	<p>
		<hello:sayHello />
	</p>
	<spring:url value="/sample/point" var="action" />
	<form:form modelAttribute="homeForm" action="${action}">
		
		<form:select path="users">
			<form:options items="${userList}" itemLabel="name" itemValue="id" />
		</form:select>
		
		<form:label path="point">付与するポイントは？</form:label>
		<form:input path="point" />
		<form:errors path="point" cssStyle="color:red" />
		<input type="submit" value="送信" />
	</form:form>


	<br />ポイント
	<br />
	<c:forEach var="point" items="${pointList}" varStatus="status">
		<br>
		<c:out value="${point.id}" />:
　　<c:out value="${point.point}" />:
   <c:out value="${point.user_id}" />:
  </c:forEach>

	<br />ポイント履歴
	<br />
	<c:forEach var="pointHistory" items="${pointHistoryList}"
		varStatus="status">
		<br>
		<c:out value="${pointHistory.id}" />:
　　<c:out value="${pointHistory.point}" />:
   <c:out value="${pointHistory.user_id}" />:
   <c:out value="${pointHistory.created_at}" />:
  </c:forEach>


</body>
</html>