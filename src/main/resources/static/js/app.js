document.addEventListener('DOMContentLoaded', () => {
    fetchEvents(); // Fetch events as soon as the page is loaded
    document.getElementById('event-form').addEventListener('submit', addEvent);
});

// Fetch events from the backend
async function fetchEvents() {
    try {
        const response = await fetch('http://localhost:8080/api/events');  // Make sure this URL matches your backend
        const events = await response.json();
        const eventsList = document.getElementById('events-list');
        eventsList.innerHTML = ''; // Clear the existing list of events

        // Loop through the events and display them on the page
        events.forEach(event => {
            const eventDiv = document.createElement('div');
            eventDiv.classList.add('event');
            eventDiv.innerHTML = `
                <h3>${event.eventName}</h3>
                <p>Date: ${event.date}</p>
                <p>Location: ${event.location}</p>
                <p>Description: ${event.description}</p>
            `;
            eventsList.appendChild(eventDiv);
        });
    } catch (error) {
        console.error('Error fetching events:', error);
    }
}

// Add a new event via a POST request
async function addEvent(e) {
    e.preventDefault();

    const eventName = document.getElementById('event-name').value;
    const eventDate = document.getElementById('event-date').value;
    const eventLocation = document.getElementById('event-location').value;
    const eventDescription = document.getElementById('event-description').value;

    const newEvent = {
        eventName: eventName,
        date: eventDate,
        location: eventLocation,
        description: eventDescription
    };

    try {
        const response = await fetch('http://localhost:8080/api/events', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newEvent)
        });

        if (response.ok) {
            alert('Event added successfully!');
            fetchEvents();  // Refresh the event list
        } else {
            alert('Failed to add event!');
        }
    } catch (error) {
        console.error('Error adding event:', error);
    }
}
