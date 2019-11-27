<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>测试管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/test/actIdUser/">测试列表</a></li>
		<shiro:hasPermission name="ceshi:actIdUser:edit"><li><a href="${ctx}/test/actIdUser/form">测试添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="actIdUser" action="${ctx}/test/actIdUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>id_：</label>
				<form:input path="id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>rev_：</label>
				<form:input path="rev" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>first_：</label>
				<form:input path="first" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>last_：</label>
				<form:input path="last" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>id_</th>
				<th>rev_</th>
				<th>first_</th>
				<th>last_</th>
				<th>email_</th>
				<shiro:hasPermission name="ceshi:actIdUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="actIdUser">
			<tr>
				<td><a href="${ctx}/ceshi/actIdUser/form?id=${actIdUser.id}">
					${actIdUser.id}
				</a></td>
				<td>
					${actIdUser.rev}
				</td>
				<td>
					${actIdUser.first}
				</td>
				<td>
					${actIdUser.last}
				</td>
				<td>
					${actIdUser.email}
				</td>
				<shiro:hasPermission name="ceshi:actIdUser:edit"><td>
    				<a href="${ctx}/test/actIdUser/form?id=${actIdUser.id}">修改</a>
					<a href="${ctx}/test/actIdUser/delete?id=${actIdUser.id}" onclick="return confirmx('确认要删除该测试吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>