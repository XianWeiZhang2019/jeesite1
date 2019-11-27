<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>贴标签管理</title>
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
		<li class="active"><a href="${ctx}/label/bfrLabelData/">贴标签列表</a></li>
		<shiro:hasPermission name="label:bfrLabelData:edit"><li><a href="${ctx}/label/bfrLabelData/form">贴标签添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="bfrLabelData" action="${ctx}/label/bfrLabelData/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标签id：</label>
				<form:input path="lableId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>数据项id：</label>
				<form:input path="dataId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>表类型：</label>
				<form:input path="dbType" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>创建人：</label>
				<form:input path="createBy.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${bfrLabelData.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
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
				<th>标签id</th>
				<th>数据项id</th>
				<th>表类型</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="label:bfrLabelData:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="bfrLabelData">
			<tr>
				<td><a href="${ctx}/label/bfrLabelData/form?id=${bfrLabelData.labelDataId}">
					${bfrLabelData.lableId}
				</a></td>
				<td>
					${bfrLabelData.dataId}
				</td>
				<td>
					${bfrLabelData.dbType}
				</td>
				<td>
					${bfrLabelData.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${bfrLabelData.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${bfrLabelData.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${bfrLabelData.remarks}
				</td>
				<shiro:hasPermission name="label:bfrLabelData:edit"><td>
    				<a href="${ctx}/label/bfrLabelData/form?id=${bfrLabelData.labelDataId}">修改</a>
					<a href="${ctx}/label/bfrLabelData/delete?id=${bfrLabelData.labelDataId}" onclick="return confirmx('确认要删除该贴标签吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>