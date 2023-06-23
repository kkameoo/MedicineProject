// Get the list of tab items
const tabItems = document.querySelectorAll('.boxtabs li');

// Add a click event listener to each tab item
tabItems.forEach(tab => {
  tab.addEventListener('click', function(event) {
    event.preventDefault(); // Prevent the default link behavior

    // Remove the "on" class from all tab items
    tabItems.forEach(item => {
      item.classList.remove('on');
    });

    // Add the "on" class to the clicked tab item
    this.classList.add('on');

    // Move the "selected" span to the clicked tab item
    const selectedSpan = this.querySelector('span.sr-only');
    document.querySelector('.boxtabs span.selected').textContent = selectedSpan.textContent;
  });
});