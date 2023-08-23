window.onload = function() {
  const clickableImage = document.getElementById('clickableImage');
  const imageSources = ['img/egg.png', 'img/egg2.png'];
  let currentIndex = 0;

  clickableImage.addEventListener('click', () => {
    currentIndex = (currentIndex + 1) % imageSources.length;
    clickableImage.src = imageSources[currentIndex];
  });
};
