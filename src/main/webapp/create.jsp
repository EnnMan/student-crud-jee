<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Create Student</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>

    <body class="bg-gray-100">
        <div class="container mx-auto px-4 py-8">
            <div class="max-w-2xl mx-auto">
                <div class="flex justify-between items-center mb-6">
                    <h1 class="text-3xl font-bold text-gray-800">Create New Student</h1>
                    <a href="students" class="text-gray-600 hover:text-gray-800">← Back to List</a>
                </div>

                <div class="bg-white rounded-lg shadow p-6">
                    <form action="students?action=insert" method="post" class="space-y-4">
                        <div>
                            <label for="fullName" class="block text-sm font-medium text-gray-700 mb-2">
                                Full Name <span class="text-red-500">*</span>
                            </label>
                            <input type="text" id="fullName" name="fullName" required
                                class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                                placeholder="Enter full name">
                        </div>

                        <div>
                            <label for="cne" class="block text-sm font-medium text-gray-700 mb-2">
                                CNE <span class="text-red-500">*</span>
                            </label>
                            <input type="text" id="cne" name="cne" required
                                class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                                placeholder="Enter CNE">
                        </div>

                        <div>
                            <label for="adresse" class="block text-sm font-medium text-gray-700 mb-2">
                                Address
                            </label>
                            <textarea id="adresse" name="adresse" rows="3"
                                class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                                placeholder="Enter address"></textarea>
                        </div>

                        <div class="flex space-x-3 pt-4">
                            <button type="submit"
                                class="flex-1 bg-blue-500 hover:bg-blue-600 text-white font-semibold px-4 py-2 rounded-lg">
                                Create Student
                            </button>
                            <a href="students"
                                class="flex-1 bg-gray-300 hover:bg-gray-400 text-gray-800 font-semibold px-4 py-2 rounded-lg text-center">
                                Cancel
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>

    </html>