<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>项目添加标签管理</title>
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
		<li class="active"><a href="${ctx}/label/bfrLabelProject/">项目添加标签列表</a></li>
		<shiro:hasPermission name="label:bfrLabelProject:edit"><li><a href="${ctx}/label/bfrLabelProject/form">项目添加标签添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="bfrLabelProject" action="${ctx}/label/bfrLabelProject/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>id：</label>
				<form:input path="labelProjectId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>标签id：</label>
				<form:input path="labelId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>项目id：</label>
				<form:input path="projectId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>other：</label>
				<form:input path="other" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>id</th>
				<th>标签id</th>
				<th>项目id</th>
				<th>other</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="label:bfrLabelProject:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bfrLabelProject">
			<tr>
				<td><a href="${ctx}/label/bfrLabelProject/form?id=${bfrLabelProject.labelProjectId}">
					${bfrLabelProject.labelProjectId}
				</a></td>
				<td>
					${bfrLabelProject.labelId}
				</td>
				<td>
					${bfrLabelProject.projectId}
				</td>
				<td>
					${bfrLabelProject.other}
				</td>
				<td>
					<fmt:formatDate value="${bfrLabelProject.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${bfrLabelProject.remarks}
				</td>
				<shiro:hasPermission name="label:bfrLabelProject:edit"><td>
    				<a href="${ctx}/label/bfrLabelProject/form?id=${bfrLabelProject.labelProjectId}">修改</a>
					<a href="${ctx}/label/bfrLabelProject/delete?id=${bfrLabelProject.labelProjectId}" onclick="return confirmx('确认要删除该项目添加标签吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>