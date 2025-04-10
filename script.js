document.addEventListener('DOMContentLoaded', function() {
    // Simular loading
    setTimeout(function() {
        document.querySelector('.loader').style.opacity = '0';
        setTimeout(function() {
            document.querySelector('.loader').style.display = 'none';
            document.querySelector('.door-container').style.display = 'flex';
        }, 1000);
    }, 2000);

    // Abrir porta
    const doorLeft = document.querySelector('.door.left');
    const doorRight = document.querySelector('.door.right');
    const knob = document.querySelector('.knob');
    const invitation = document.querySelector('.invitation');
    const mainContent = document.querySelector('main');

    function openDoor() {
        doorLeft.style.transform = 'rotateY(-120deg)';
        doorRight.style.transform = 'rotateY(120deg)';
        knob.style.opacity = '0';
        invitation.style.opacity = '0';
        
        setTimeout(function() {
            document.querySelector('.door-container').style.opacity = '0';
            setTimeout(function() {
                document.querySelector('.door-container').style.display = 'none';
                mainContent.classList.remove('hidden');
                
                // Acender vela
                setTimeout(function() {
                    document.querySelector('.flame').style.opacity = '1';
                }, 1000);
                
                // Mostrar itens da timeline
                const timelineItems = document.querySelectorAll('.timeline-item');
                timelineItems.forEach((item, index) => {
                    setTimeout(() => {
                        item.classList.add('show');
                    }, index * 300);
                });
            }, 1000);
        }, 1500);
    }

    knob.addEventListener('click', openDoor);
    invitation.addEventListener('click', openDoor);

    // Botão de surpresa
    const surpriseBtn = document.getElementById('surprise-btn');
    const canvas = document.getElementById('confetti-canvas');

    surpriseBtn.addEventListener('click', function() {
        // Configurar canvas de confete
        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;
        canvas.style.position = 'fixed';
        canvas.style.top = '0';
        canvas.style.left = '0';
        canvas.style.pointerEvents = 'none';
        canvas.style.zIndex = '1000';
        canvas.style.display = 'block';
        
        // Animação de confete
        const ctx = canvas.getContext('2d');
        const confettiPieces = [];
        const colors = ['#ff9ff3', '#feca57', '#ff6b6b', '#48dbfb', '#1dd1a1'];
        
        for (let i = 0; i < 150; i++) {
            confettiPieces.push({
                x: Math.random() * canvas.width,
                y: Math.random() * canvas.height - canvas.height,
                size: Math.random() * 10 + 5,
                color: colors[Math.floor(Math.random() * colors.length)],
                speed: Math.random() * 3 + 2,
                angle: Math.random() * 6.28,
                rotationSpeed: Math.random() * 0.2 - 0.1
            });
        }
        
        function animateConfetti() {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            
            let stillActive = false;
            
            confettiPieces.forEach(confetto => {
                ctx.save();
                ctx.translate(confetto.x, confetto.y);
                ctx.rotate(confetto.angle);
                
                ctx.fillStyle = confetto.color;
                ctx.fillRect(-confetto.size/2, -confetto.size/2, confetto.size, confetto.size);
                
                ctx.restore();
                
                confetto.y += confetto.speed;
                confetto.angle += confetto.rotationSpeed;
                
                if (confetto.y < canvas.height) {
                    stillActive = true;
                }
            });
            
            if (stillActive) {
                requestAnimationFrame(animateConfetti);
            } else {
                canvas.style.display = 'none';
            }
        }
        
        animateConfetti();
        
        // Mostrar mensagem especial
        alert('Parabéns, Gii! Que seu dia seja incrível e que Deus continue te abencoando sempre! 🎉');
    });

    // Personalizar nome
    const friendName = document.getElementById('friend-name');
    const friendName2 = document.getElementById('friend-name-2');
    const name = prompt('Digite seu nome:');
    if (name) {
        friendName.textContent = name;
        friendName2.textContent = name;
    }

    // Atualizar data do aniversário
    const today = new Date();
    const options = { day: 'numeric', month: 'long' };
    document.getElementById('birthday-date').textContent = today.toLocaleDateString('pt-BR', options);
});