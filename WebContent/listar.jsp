<%@ page import="br.com.agenda.model.Contato"%>
<%@ page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de contatos</title>
</head>
<body>
	<c:url var="novoContatoUrl" value="/Editar" />
	<a href="${novoContatoUrl}">Criar Contato</a>
	<br>
	<br>
	<table width="100%" border="1">
		<tr>
			<td align="center"><strong>Nome</strong>
			<td align="center"><strong>Telefone</strong>
			<td align="center"><strong>Opções</strong>
		</tr>
		<c:choose>
			<c:when test="${empty(contatos)}">
				<td colspan="3" align="center">Nenhum contato cadastrado</td>
			</c:when>
			<c:otherwise>
				<c:forEach var="contato" items="${contatos}">
					<tr>
						<c:url var="editarContatoUrl" value="/Editar">
							<c:param name="id">${contato.id}</c:param>
						</c:url>
						<c:url var="excluirContatoUrl" value="/Excluir">
							<c:param name="id">${contato.id}</c:param>
						</c:url>
						<td align="center"><a href="${editarContatoUrl}">${contato.nome}</a></td>
						<td align="center"><a>${contato.telefone}</a></td>
						<td align="center"><a href="${excluirContatoUrl}">Excluir</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>