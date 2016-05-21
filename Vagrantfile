# -*- mode: ruby -*-
# vi: set ft=ruby :

# Load settings vars
require 'yaml'
settings = YAML.load_file 'development_var.yml'

# Vagrantfile API/syntax version.
VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|
  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://atlas.hashicorp.com/search.
  config.vm.box = "ubuntu/trusty64"

  # If true, then any SSH connections made will enable agent forwarding.
  # Default value: false
  config.ssh.forward_agent = true

  config.vm.define settings['vm_hostname'] do |machine|
      config.vm.provider "virtualbox" do |v|
          v.name = settings['vm_name']
      end
      machine.vm.hostname = settings['vm_hostname']
      machine.vm.network "private_network", ip: settings['vm_ip']
      machine.vm.network "forwarded_port", guest: 80, host: settings['vm_http_guest_port'], id: "postgres"
      machine.vm.network "forwarded_port", guest: 6379, host: settings['vm_redis_guest_port'], id: "redis"
      machine.vm.network "forwarded_port", guest: 5432, host: settings['vm_postgres_guest_port'], id: "postgres"
      machine.vm.network "forwarded_port", guest: 22, host: settings['vm_ssh_guest_port'], id: "ssh"
      #machine.vm.network "forwarded_port", guest: 5000, host: settings['vm_api_guest_port'], id: "api"
      machine.vm.network "forwarded_port", guest: 3000, host: settings['vm_ui_guest_port'], id: "ui"
      machine.vm.network "forwarded_port", guest: 9100, host: settings['vm_goconvey_guest_port'], id: "goconvey"

      machine.vm.synced_folder ".", settings['project_dir']

      machine.vm.provision "ansible" do |ansible|
        ansible.playbook = "infrastructure/provision.yml"
        ansible.sudo = true
        #ansible.ask_vault_pass = true
        ansible.limit = "all"
        ansible.groups = {
          "appservers" => ["app01"],
          "pgservers" => ["app01"],
          "redisservers" => ["app01"],
          "nginxservers" => ["app01"],
          #"apiservers:children" => ["app01"],
          "uiservers:children" => ["app01"]
        }
        ansible.extra_vars = {
            ansible_ssh_user: "vagrant",
            stack: "development"
        }
        ansible.verbose = "vvvv"
      end
  end
end
