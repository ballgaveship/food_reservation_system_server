echo $GITHUB_PACKAGES_PASSWORD | docker login docker.pkg.github.com -u ballgaveship --password-stdin
docker-compose stop
docker-compose rm -f
docker-compose pull
docker-compose up -d