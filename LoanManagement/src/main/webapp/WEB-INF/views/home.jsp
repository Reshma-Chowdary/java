<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Tabbed Interface</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .tab-content {
            display: none;
        }

        .active-tab {
            display: block;
        }

        .nav-tabs a {
            cursor: pointer;
        }

        /* Hide the "Next" and "Previous" buttons in the last tab */
        .hide-buttons #prevButton, .hide-buttons #nextButton {
            display: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link active" href="#" data-tab="tab1">Tab 1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" data-tab="tab2">Tab 2</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" data-tab="tab3">Tab 3</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" data-tab="tab4">Tab 4 (Preview/Save)</a>
            </li>
        </ul>

        <div class="tab-content">
            <div id="tab1" class="tab-pane active-tab">
                Content of Tab 1
            </div>
            <div id="tab2" class="tab-pane">
                Content of Tab 2
            </div>
            <div id="tab3" class="tab-pane">
                Content of Tab 3
            </div>
            <div id="tab4" class="tab-pane"> <!-- Remove the class to hide buttons -->
                Content of Tab 4
                <button id="previewButton" class="btn btn-primary">Preview</button>
                <button id="saveButton" class="btn btn-primary">Save</button>
            </div>
        </div>

        <button id="prevButton" class="btn btn-primary">Previous</button>
        <button id="nextButton" class="btn btn-primary">Next</button>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            var currentTab = 1;
            var tabLinks = document.querySelectorAll('.nav-tabs a');
            var prevButton = document.querySelector('#prevButton');
            var nextButton = document.querySelector('#nextButton');
            var previewButton = document.querySelector('#previewButton');
            var saveButton = document.querySelector('#saveButton');

            function showTab(tabId) {
                tabLinks.forEach(function (tabLink) {
                    tabLink.classList.remove('active');
                });

                var tabContent = document.querySelectorAll('.tab-content .tab-pane');
                tabContent.forEach(function (tab) {
                    tab.classList.remove('active-tab');
                });

                document.querySelector('#' + tabId).classList.add('active-tab');
                document.querySelector('[data-tab="' + tabId + '"]').classList.add('active');

                // Hide "Previous" and "Next" buttons on the 4th tab
                if (currentTab === 4) {
                    prevButton.style.display = 'none';
                    nextButton.style.display = 'none';
                } else {
                    prevButton.style.display = 'inline-block';
                    nextButton.style.display = 'inline-block';
                }
		// Disable/Enable Previous and Next buttons based on the currentTab
                if (currentTab === 1) {
                    prevButton.disabled = true;
                    nextButton.disabled = false;
                }  else {
                    prevButton.disabled = false;
                    nextButton.disabled = false;
                }
            }

            document.querySelector('#nextButton').addEventListener('click', function () {
                if (currentTab === 4) {
                    // You can add your logic here to go to another page
                    alert('Going to another page.');
                    return;
                } else if (currentTab === tabLinks.length) {
                    // If on the last tab, do not change the tab
                    return;
                } else {
                    currentTab++;
                    var nextTabId = 'tab' + currentTab;
                    showTab(nextTabId);
                }
            });

            document.querySelector('#prevButton').addEventListener('click', function () {
                currentTab--;
                if (currentTab < 1) {
                    currentTab = tabLinks.length;
                }
                var prevTabId = 'tab' + currentTab;
                showTab(prevTabId);
            });

            // Initialize by showing the first tab
            showTab('tab1');

            // Handle actions for the "Preview" and "Save" buttons
            previewButton.addEventListener('click', function () {
                alert('Preview clicked.');
            });

            saveButton.addEventListener('click', function () {
                alert('Save clicked.');
            });
        });
    </script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>