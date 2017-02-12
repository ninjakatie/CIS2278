#!/bin/sh

#     *************************************************
#     this script stops the Derby DB

. ./dbSetenv_ndnu.sh

java org.apache.derby.drda.NetworkServerControl shutdown
