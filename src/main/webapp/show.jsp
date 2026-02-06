<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Student Details</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>

    <body class="bg-gray-100">
        <div class="container mx-auto px-4 py-8">
            <div class="max-w-2xl mx-auto">
                <div class="flex justify-between items-center mb-6">
                    <h1 class="text-3xl font-bold text-gray-800">Student Details</h1>
                    <a href="students" class="text-gray-600 hover:text-gray-800">← Back to List</a>
                </div>

                <div class="bg-white rounded-lg shadow p-6">
                    <div class="space-y-4">
                        <div class="border-b pb-3">
                            <label class="text-sm font-medium text-gray-500">Full Name</label>
                            <p class="text-lg text-gray-900">${student.fullName}</p>
                        </div>

                        <div class="border-b pb-3">
                            <label class="text-sm font-medium text-gray-500">CNE</label>
                            <p class="text-lg text-gray-900">${student.cne}</p>
                        </div>

                        <div class="border-b pb-3">
                            <label class="text-sm font-medium text-gray-500">Address</label>
                            <p class="text-lg text-gray-900">${student.adresse}</p>
                        </div>
                    </div>

                    <div class="flex space-x-3 mt-6">
                        <a href="students?action=edit&id=${student.id}&from=show"
                            class="flex-1 bg-green-500 hover:bg-green-600 text-white font-semibold px-4 py-2 rounded-lg text-center">
                            Edit
                        </a>
                        <a href="students?action=delete&id=${student.id}"
                            onclick="return confirm('Are you sure you want to delete this student?')"
                            class="flex-1 bg-red-500 hover:bg-red-600 text-white font-semibold px-4 py-2 rounded-lg text-center">
                            Delete
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </body>

    </html>