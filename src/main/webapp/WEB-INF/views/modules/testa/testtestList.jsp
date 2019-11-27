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
		<li class="active"><a href="${ctx}/testa/testtest/">测试列表</a></li>
		<shiro:hasPermission name="testa:testtest:edit"><li><a href="${ctx}/testa/testtest/form">测试添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="testtest" action="${ctx}/testa/testtest/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<shiro:hasPermission name="anpaishiyan">
			<li class="btns"><input id="btnSubmi1t" class="btn btn-primary" type="button" value="安排实验"/></li>
			</shiro:hasPermission>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>姓名</th>
				<th>创建者</th>
				<th>创建时间</th>
				<th>更新者</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="testa:testtest:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="testtest">
			<tr>
				<td><a href="${ctx}/testa/testtest/form?id=${testtest.id}">
					${testtest.name}
				</a></td>
				<td>
					${testtest.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${testtest.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${testtest.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${testtest.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${testtest.remarks}
				</td>
				<shiro:hasPermission name="testa:testtest:edit"><td>
    				<a href="${ctx}/testa/testtest/form?id=${testtest.id}">修改</a>
					<a href="${ctx}/testa/testtest/delete?id=${testtest.id}" onclick="return confirmx('确认要删除该测试吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>