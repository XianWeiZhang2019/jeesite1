<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>标签管理</title>
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
		<li class="active"><a href="${ctx}/label/bfrLabel/">标签列表</a></li>
		<shiro:hasPermission name="label:bfrLabel:edit"><li><a href="${ctx}/label/bfrLabel/form">标签添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="bfrLabel" action="${ctx}/label/bfrLabel/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标签名称：</label>
				<form:input path="labelName" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>other：</label>
				<form:input path="other" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>备注：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="1000" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>标签名称</th>
				<th>other</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="label:bfrLabel:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bfrLabel">
			<tr>
				<td><a href="${ctx}/label/bfrLabel/form?id=${bfrLabel.labelId}">
					${bfrLabel.labelName}
				</a></td>
				<td>
					${bfrLabel.other}
				</td>
				<td>
					<fmt:formatDate value="${bfrLabel.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${bfrLabel.remarks}
				</td>
				<shiro:hasPermission name="label:bfrLabel:edit"><td>
    				<a href="${ctx}/label/bfrLabel/form?id=${bfrLabel.labelId}">修改</a>
					<a href="${ctx}/label/bfrLabel/delete?id=${bfrLabel.id}" onclick="return confirmx('确认要删除该标签吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>