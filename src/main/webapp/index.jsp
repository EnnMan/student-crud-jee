<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Students List</title>
      <script src="https://cdn.tailwindcss.com"></script>
    </head>

    <body class="bg-gray-100">
      <div class="container mx-auto px-4 py-8">
        <div class="flex justify-between items-center mb-6">
          <h1 class="text-3xl font-bold text-gray-800">Students List</h1>
          <a href="students?action=new"
            class="bg-blue-500 hover:bg-blue-600 text-white font-semibold px-6 py-2 rounded-lg shadow">
            + New Student
          </a>
        </div>

        <div class="bg-white rounded-lg shadow overflow-hidden">
          <table class="min-w-full divide-y divide-gray-200">
            <thead class="bg-gray-50">
              <tr>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Full Name
                </th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">CNE</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Address</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
              </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
              <c:forEach var="student" items="${students}">
                <tr class="hover:bg-gray-50">
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900">${student.fullName}</td>
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900">${student.cne}</td>
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-900">${student.adresse}</td>
                  <td class="px-6 py-4 whitespace-nowrap text-sm font-medium space-x-2">
                    <a href="students?action=show&id=${student.id}" class="text-blue-600 hover:text-blue-900">Show</a>
                    <a href="students?action=edit&id=${student.id}" class="text-green-600 hover:text-green-900">Edit</a>
                    <a href="students?action=delete&id=${student.id}"
                      onclick="return confirm('Are you sure you want to delete this student?')"
                      class="text-red-600 hover:text-red-900">Delete</a>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </body>

    </html>