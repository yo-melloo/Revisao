const panel = document.querySelector('.login-panel.autoexpand');
const panel2 = document.querySelector('#contact.autoexpand');
if (panel) {
  panel.addEventListener('mouseenter', () => {
    panel.classList.add('expanded');
    // autofocus opcional
    const firstInput = panel.querySelector('input');
    if (firstInput) setTimeout(() => firstInput.focus(), 300);
  });
  panel.addEventListener('focusin', () => {
    panel.classList.add('expanded');
  });
}
