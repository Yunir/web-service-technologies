Vagrant.configure("2") do |config|
    config.vm.box = "ubuntu/trusty64"

    # PostgreSQL configuration
    # Learn more: https://github.com/jackdb/pg-app-dev-vm
    config.vm.provision :shell, :path => "postgresql.sh"
    config.vm.network :forwarded_port, guest: 15432, host: 5432

end