function toggleMenu() {
    const menuDropDownDOM = document.querySelector('#mobile-menu');
    const menuIconsDOM = document.querySelectorAll('svg[name="menu-icon"]');

    if (menuDropDownDOM.style.display === 'block') {
        menuIconsDOM[0].style.display = 'block';
        menuIconsDOM[1].style.display = 'none';

        menuDropDownDOM.style.display = 'none';
    }
    else {
        menuIconsDOM[0].style.display = 'none';
        menuIconsDOM[1].style.display = 'block';

        menuDropDownDOM.style.display = 'block';
    }
}