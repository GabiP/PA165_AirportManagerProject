<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:pagetemplate title="Steward detail information">
    <jsp:attribute name="body">

        <div>
            <table class="table">
                <tr>
                    <td class="col-md-2"><b>ID</b></td>
                    <td>${steward.id}</td>
                </tr>
                <tr>
                    <td class="col-md-2"><b>First Name</b></td>
                    <td>${steward.firstname}</td>
                </tr>
                <tr>
                    <td class="col-md-2"><b>Surname</b></td>
                    <td>${steward.surname}</td>
                </tr>
                <tr>
                    <td class="col-md-2"><b>Username</b></td>
                    <td>${steward.username}</td>
                </tr>
                <c:if test="${steward.admin}">
                    <tr>
                        <td class="col-md-2"><b>Role</b></td>
                        <td>Administrator</td>
                    </tr>    
                </c:if>
                <c:if test="${steward.admin == false}">
                    <tr>
                        <td class="col-md-2"><b>Role</b></td>
                        <td>User</td>
                    </tr>    
                </c:if>
                <tr>
                    <td class="col-md-2"><b>Personal ID</b></td>
                    <td>${steward.personalIdentificator}</td>
                </tr>
                <tr>
                    <td class="col-md-2"><b>Gender</b></td>
                    <td><c:out value="${steward.gender}"/></td>
                </tr>
                <tr>
                    <td class="col-md-2"><b>Date Of Birth</b></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${steward.dateOfBirth}"/></td>
                </tr>
                <tr>
                    <td class="col-md-2"><b>Employment Date</b></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${steward.employmentDate}"/></td>
                </tr>
                <tr>
                    <td class="col-md-1">
                        <a href="${pageContext.request.contextPath}/steward/edit/${steward.id}" class="btn btn-primary btn-block">Edit</a>
                    </td>
                    <td>
                        <input type="button" value="Back" onclick="history.go(-1)" class="btn btn-danger">
                    </td>
                </tr>
            </table>
            <c:if test="${flights.size() > 0}">
                <h2 class="col-md-12">Flights</h2>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Origin</th>
                            <th>Destination</th>
                            <th>Arrival</th>
                            <th>Departure</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${flights}" var="flight">
                            <tr>
                                <td class="col-md-1 align-middle"><c:out value="${flight.origin.location}"/></td>
                                <td class="col-md-1 align-middle"><c:out value="${flight.destination.location}"/></td>
                                <td class="col-md-1 align-middle"><fmt:formatDate pattern="yyyy-MM-dd" value="${flight.arrival}"/></td>
                                <td class="col-md-1 align-middle"><fmt:formatDate pattern="yyyy-MM-dd" value="${flight.departure}"/></td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/flight/detail/${flight.id}" class="btn btn-info">View</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>

    </jsp:attribute>
</my:pagetemplate>