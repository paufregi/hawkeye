.PHONY : help ci ci-validate concourse-login
.DEFAULT_GOAL := help


### CI
ci : ci-login ## Set all the pipeline in concourse
	fly -t local set-pipeline -p katana -c katana/ci/pipeline.yml -l ci/credentials.yml
	fly -t local set-pipeline -p archery -c archery/ci/pipeline.yml -l ci/credentials.yml
	fly -t local set-pipeline -p crossbow -c crossbow/ci/pipeline.yml -l ci/credentials.yml

ci-validate : ci-login ## Validate pipelines
	fly validate-pipeline -c katana/ci/pipeline.yml -l ci/credentials.yml
	fly validate-pipeline -c archery/ci/pipeline.yml -l ci/credentials.yml
	fly validate-pipeline -c crossbow/ci/pipeline.yml -l ci/credentials.yml

ci-login : ## Concourse login
	fly login -t local -u test -p test -c http://127.0.0.1:8080


### HELP
help: ## Show this help dialog.
	@IFS=$$'\n' ; \
	help_lines=(`fgrep -h "##" $(MAKEFILE_LIST) | grep -v '###' | sed -e 's/\\$$//' | sed -e 's/##/:/'`); \
	printf "%-30s %s\n" "target" "description" ; \
	printf "%-30s %s\n" "------" "-----------" ; \
	for help_line in $${help_lines[@]}; do \
		IFS=$$':' ; \
		help_split=($$help_line) ; \
		help_command=`echo $${help_split[0]} | sed -e 's/^ *//' -e 's/ *$$//'` ; \
		help_info=`echo $${help_split[2]} | sed -e 's/^ *//' -e 's/ *$$//'` ; \
		printf '\033[36m'; \
		printf "%-30s %s" $$help_command ; \
		printf '\033[0m'; \
		printf "%s\n" $$help_info; \
	done