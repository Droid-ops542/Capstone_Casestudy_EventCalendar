document.addEventListener('DOMContentLoaded', function () {

    // Toggle event details visibility
    const eventDetailsButtons = document.querySelectorAll('.event-details-btn');
    eventDetailsButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            const eventDetails = button.nextElementSibling;
            eventDetails.classList.toggle('hidden');
        });
    });

    // Initialize Date Picker for event date inputs
    const dateInputs = document.querySelectorAll('.date-input');
    dateInputs.forEach(function(dateInput) {
        dateInput.addEventListener('focus', function() {
            initializeDatePicker(dateInput);
        });
    });

    // Function to initialize a date picker (simple example, can be replaced with a library like flatpickr)
    function initializeDatePicker(inputElement) {
        if (!inputElement.classList.contains('initialized')) {
            inputElement.type = 'date';
            inputElement.classList.add('initialized');
        }
    }

    // Example: Form validation for event creation form
    const eventForm = document.getElementById('eventForm');
    if (eventForm) {
        eventForm.addEventListener('submit', function(event) {
            if (!validateEventForm(eventForm)) {
                event.preventDefault(); // Prevent form submission if validation fails
                alert('Please fill in all required fields correctly.');
            }
        });
    }

    // Function to validate the event form
    function validateEventForm(form) {
        const nameInput = form.querySelector('input[name="name"]');
        const dateInput = form.querySelector('input[name="date"]');
        const descriptionInput = form.querySelector('textarea[name="description"]');

        let isValid = true;

        // Simple validation: check if all fields are filled
        if (!nameInput.value || !dateInput.value || !descriptionInput.value) {
            isValid = false;
        }

        // Additional validation could go here (e.g., check for valid email format)
        return isValid;
    }

    // Example: Event Search Functionality (if you have a search bar)
    const searchInput = document.getElementById('eventSearch');
    if (searchInput) {
        searchInput.addEventListener('input', function() {
            const searchTerm = searchInput.value.toLowerCase();
            const eventCards = document.querySelectorAll('.event-card');

            eventCards.forEach(function(card) {
                const eventName = card.querySelector('h3').innerText.toLowerCase();
                if (eventName.includes(searchTerm)) {
                    card.style.display = 'block';
                } else {
                    card.style.display = 'none';
                }
            });
        });
    }
});
