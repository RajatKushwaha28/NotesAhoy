// Initialize SpeechRecognition
const recognition = new (window.SpeechRecognition || window.webkitSpeechRecognition)();
recognition.interimResults = true;

// Event listeners
click_to_convert.addEventListener('click', function(event) {
    event.preventDefault();
    startRecognition();
});

recognition.onresult = function(event) {
    let transcript = '';
    for (let i = event.resultIndex; i < event.results.length; i++) {
        if (event.results[i].isFinal) {
            transcript += event.results[i][0].transcript;
        }
    }
    // Append the transcript to the existing content of the textarea
    if (transcript.trim() !== '') {
        content.value += transcript.trim() + ' ';
    }
};

recognition.onerror = function(event) {
    console.error('Speech recognition error:', event.error);
};

// Function to start recognition
function startRecognition() {
    recognition.start();
}
