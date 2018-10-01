FLY = fly
CONCOURSE_URL = http://127.0.0.1:8080
CONCOURSE_USER = test
CONCOURSE_PASSWORD = test

.PHONY : ci concourse-login help

### CI
ci: concourse-login
	$(FLY) -t local set-pipeline -p clint -c ci/pipeline.yml -l ../ci/credentials.yml

concourse-login :
	$(FLY) login -t local -u $(CONCOURSE_USER) -p $(CONCOURSE_PASSWORD) -c $(CONCOURSE_URL)


### Misc
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