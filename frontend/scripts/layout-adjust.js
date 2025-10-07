document.addEventListener('DOMContentLoaded', () => {
    // Insere header
    fetch('header.html')
        .then(r=>r.text())
        .then(html=>{
            document.getElementById('site-header').innerHTML = html;
        });

// Insere footer
    fetch('footer.html')
        .then(r=>r.text())
        .then(html=>{
          document.getElementById('site-footer').innerHTML = html;
    });
});