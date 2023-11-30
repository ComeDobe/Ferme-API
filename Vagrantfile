Vagrant.configure("2") do |config|
  config.vm.box = "bento/ubuntu-20.04"

  # Rediriger le port 8080 de la VM vers le port 8080 de l'hôte
  config.vm.network "forwarded_port", guest: 8080, host: 8080

  # Provision Docker
  config.vm.provision "docker"

  # Provision avec un script pour installer Docker Compose
  config.vm.provision "shell", inline: <<-SHELL
    # Installer Docker Compose
    sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
    sudo chmod +x /usr/local/bin/docker-compose

    # Utiliser docker-compose pour démarrer les services
    cd /vagrant # Assurez-vous que votre docker-compose.yml est dans le répertoire partagé /vagrant
    docker-compose up -d
  SHELL
end
