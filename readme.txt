The program monitors websites by checking their status codes and content,
and compares the content found with content requirements, defined in config.properties.
It isn't, however, fully complete yet:

# It shows the current status on path /status, and prints out the same information. Spring Boot is utilized for the former.
The website was left basically undone due to time constraints, it only returns the required information in JSON.

# The log with above information is saved as a text file called "monitorlog". The log could do with some fine tuning though.

# Periodic checks and server response time are excluded as of now; for further improvement, they would need to be included.

# For periodic checks, one alternative seems to be the ScheduledExecutorService. An attempt on response time was left commented
in URLController.java, however it did not provide much usability in its current location.