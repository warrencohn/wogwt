#! /bin/bash

find javadoc -iname '*.html' -exec svn propset svn:mime-type "text/html" {} \;
find javadoc -iname '*.css' -exec svn propset svn:mime-type "text/css" {} \;
find javadoc -iname '*.gif' -exec svn propset svn:mime-type "image/gif" {} \;
